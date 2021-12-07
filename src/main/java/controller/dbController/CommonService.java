package controller.dbController;


import model.ObjectWithID;
import org.hibernate.Session;
import java.util.ArrayList;

public class CommonService {
    public static void DeleteItemsHandler(Session session, String itemsType, ArrayList<ObjectWithID> items) {
        String queryText = String.format("delete %s where ID = :ItemID", itemsType);
        for(ObjectWithID item : items) {
            session.createQuery(queryText)
                    .setParameter("ItemID", item.ID)
                    .executeUpdate();
        }
    }
}
