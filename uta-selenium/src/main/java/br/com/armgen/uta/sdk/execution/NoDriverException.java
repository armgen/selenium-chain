package br.com.armgen.uta.sdk.execution;

/**
 * Created by Pedro on 24/01/2017.
 */
public class NoDriverException extends RuntimeException {

    /**
     * Constructs a <code>NoDriverException</code> with <tt>null</tt>
     * as its error message string.
     */
    public NoDriverException() {
        super();
    }

    /**
     * Constructs a <code>NoDriverException</code>, saving a reference
     * to the error message string <tt>s</tt> for later retrieval by the
     * <tt>getMessage</tt> method.
     *
     * @param   s   the detail message.
     */
    public NoDriverException(String s) {
        super(s);
    }
}
