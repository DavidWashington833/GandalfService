package com.gandalf.models;




public class ItemPedidoId  implements java.io.Serializable {


     private int idProduto;
     private int idPedido;

    public ItemPedidoId() {
    }

    public ItemPedidoId(int idProduto, int idPedido) {
       this.idProduto = idProduto;
       this.idPedido = idPedido;
    }
   
    public int getIdProduto() {
        return this.idProduto;
    }
    
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public int getIdPedido() {
        return this.idPedido;
    }
    
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ItemPedidoId) ) return false;
		 ItemPedidoId castOther = ( ItemPedidoId ) other; 
         
		 return (this.getIdProduto()==castOther.getIdProduto())
 && (this.getIdPedido()==castOther.getIdPedido());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdProduto();
         result = 37 * result + this.getIdPedido();
         return result;
   }   


}


