package wsminorsaffairs;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import wsminorsaffairs.entities.VwGafmaDetail;
import wsminorsaffairs.entities.WvResponseCodeLookup;

@Stateless(name = "MADBManagerEJB", mappedName = "MinorsAffairsWSApp-WSContractInfo-MADBManagerEJB")
public class MADBManagerEJBBean implements MADBManagerEJBLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "WSMinorsAffairs")
    private EntityManager em;

    public MADBManagerEJBBean() {
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    public void removeWvResponseCodeLookup(WvResponseCodeLookup wvResponseCodeLookup) {
        wvResponseCodeLookup = em.find(WvResponseCodeLookup.class, wvResponseCodeLookup.getResponsecode());
        em.remove(wvResponseCodeLookup);
    }

    /** <code>select o from WvResponseCodeLookup o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<WvResponseCodeLookup> getWvResponseCodeLookupFindAll() {
        return em.createNamedQuery("WvResponseCodeLookup.findAll", WvResponseCodeLookup.class).getResultList();
    }

    /** <code>select o from WvResponseCodeLookup o where o.responsecode = :code</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public WvResponseCodeLookup getWvResponseCodeLookupFindByCode(String code) {
        return em.createNamedQuery("WvResponseCodeLookup.findByCode", WvResponseCodeLookup.class)
                 .setParameter("code", code)
                 .getSingleResult();
    }

    /** <code>select o from VwGafmaDetail o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<VwGafmaDetail> getVwGafmaDetailFindAll() {
        return em.createNamedQuery("VwGafmaDetail.findAll", VwGafmaDetail.class).getResultList();
    }

    /** <code>select o from VwGafmaDetail o where o.qid = :qid and o.issuemonth = :issuemonth</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<VwGafmaDetail> getVwGafmaDetailFindByQIDandMonth(Long qid, String issuemonth) {
        return em.createNamedQuery("VwGafmaDetail.findByQIDandMonth", VwGafmaDetail.class)
                 .setParameter("qid", qid)
                 .setParameter("issuemonth", issuemonth)
                 .getResultList();
    }
}
