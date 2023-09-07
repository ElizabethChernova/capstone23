
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;

@MongoEntity(collection = "activity")
public class Activity {

    public ObjectId activityId;

}