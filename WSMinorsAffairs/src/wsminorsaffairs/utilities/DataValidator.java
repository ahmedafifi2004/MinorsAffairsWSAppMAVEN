package wsminorsaffairs.utilities;



public class DataValidator {
    public DataValidator() {
        super();
    }
    
    
   
    
    
    public static boolean validateRequiredQueryData(MinorsAffairsRequest request){
        
        boolean valid=true;
        
        valid=(request.getQid()!=null  ) && ! (request.getQid().longValue() == 0);
        valid=valid &&(request.getIssuemonth()!=null  && ! request.getIssuemonth().equalsIgnoreCase(""));
        
        return valid;
        
        
    }
    
    
    
}
