package liga.medical.medicalpersonservice.core.mapper;

import java.util.List;
import liga.medical.medicalpersonservice.core.model.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AddressMapper {

    @Select("select * from address")
    List<Address> getAllAddresses();

    @Select("select * from address where id = #{id}")
    Address getAddressById(@Param("id") long id);

    @Select("select * from address where contact_id = #{contact_id}")
    Address getAddressByContactId(@Param("contactId") long contactId);

    @Insert("insert into address (contact_id, country_id, city, index, street, building, flat)" +
            " values(#{contact_id}, #{country_id}, #{city}, #{index}, #{street}, #{building}, #{flat})")
    void insertAddress(Address address);
}
