package br.com.pitang.desafio.exceptions;

/**
 * @author rianmachado@gmail.com
 */
public class BusinessException extends RuntimeException {

	
	private static final long serialVersionUID = -5521779002961612630L;
	
	private CodeMsg bundle;
	
    
	public BusinessException(CodeMsg bundle, RuntimeException runtimeException) {
        super(bundle.getIdBundle(), runtimeException);
        this.bundle = bundle;
    }

    public BusinessException(CodeMsg bundle) {
        super(bundle.getIdBundle());
        this.bundle = bundle;
    }

    public CodeMsg getbundle() {
        return bundle;
    }

    

}
