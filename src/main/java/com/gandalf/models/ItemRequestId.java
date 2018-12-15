package com.gandalf.models;




public class ItemRequestId  implements java.io.Serializable {


     private int idProduct;
     private int idRequest;

    public ItemRequestId() {
    }

    public ItemRequestId(int idProduto, int idPedido) {
       this.idProduct = idProduto;
       this.idRequest = idPedido;
    }
   
    public int getIdProduct() {
        return this.idProduct;
    }
    
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
    public int getIdRequest() {
        return this.idRequest;
    }
    
    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ItemRequestId) ) return false;
		 ItemRequestId castOther = ( ItemRequestId ) other; 
         
		 return (this.getIdProduct()==castOther.getIdProduct())
 && (this.getIdRequest()==castOther.getIdRequest());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdProduct();
         result = 37 * result + this.getIdRequest();
         return result;
   }   


}


