    package muckkitlist_spring.muckkitlist_spring.utility;

    import lombok.Data;
    import muckkitlist_spring.muckkitlist_spring.entity.RestaurantInfoEntity;
    import muckkitlist_spring.muckkitlist_spring.entity.MuckatListEntity;

    import java.io.Serializable;

    @Data
    public class MuckatMemoComposite implements Serializable {
        private RestaurantInfoEntity restaurantInfoEntity;
        private MuckatListEntity muckatListEntity;
    }
