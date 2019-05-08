package wsminorsaffairs;

import java.util.List;

import javax.ejb.Local;

import wsminorsaffairs.entities.VwGafmaDetail;
import wsminorsaffairs.entities.WvResponseCodeLookup;

@Local
public interface MADBManagerEJBLocal {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    void removeWvResponseCodeLookup(WvResponseCodeLookup wvResponseCodeLookup);

    List<WvResponseCodeLookup> getWvResponseCodeLookupFindAll();

   WvResponseCodeLookup getWvResponseCodeLookupFindByCode(String code);

    List<VwGafmaDetail> getVwGafmaDetailFindAll();

    List<VwGafmaDetail> getVwGafmaDetailFindByQIDandMonth(Long qid, String issuemonth);
}
