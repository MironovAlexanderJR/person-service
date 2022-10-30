package liga.medical.medicalpersonservice.core.mapper;

import java.util.Optional;
import liga.medical.medicalpersonservice.core.model.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountMapper {

    @Select("select * from account where email = #{email}")
    Optional<Account> findByEmail(@Param("email") String email);

    @Select("select * from account where token = #{token}")
    Optional<Account> findByToken(@Param("token") String token);

    @Insert("insert into account (name, role, state, email, password) " +
            "values(#{name}, #{role}, #{state}, #{email}, #{password})")
    void createAccount(Account account);

    @Update("update account set token = #{token} where email = #{email}")
    void updateTokenByEmail(@Param("token") String token, @Param("email") String email);

    @Update("update account set state = #{state} where email = #{email}")
    void confirmationByEmail(@Param("state") String state, @Param("email") String email);
}
