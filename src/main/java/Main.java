import javax.naming.NamingException;
import javax.transaction.*;

public class Main {
    public static void main(String[] agrs) throws HeuristicMixedException, RollbackException, SystemException, NamingException, HeuristicRollbackException, NotSupportedException, ClassNotFoundException {
        MessageService messageService = new MessageService();
        messageService.test();
    }
}
