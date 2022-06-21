package jpashop.zuiop.exception;

public class NotZuiopEnoughStockException extends RuntimeException{
    public NotZuiopEnoughStockException() {
        super();
    }

    public NotZuiopEnoughStockException(String message) {
        super(message);
    }

    public NotZuiopEnoughStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotZuiopEnoughStockException(Throwable cause) {
        super(cause);
    }

    protected NotZuiopEnoughStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
