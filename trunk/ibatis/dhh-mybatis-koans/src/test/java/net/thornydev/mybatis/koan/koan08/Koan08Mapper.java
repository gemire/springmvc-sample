package net.thornydev.mybatis.koan.koan08;

import net.thornydev.mybatis.koan.domain.Country;

import org.apache.ibatis.annotations.Delete;

public interface Koan08Mapper {

  @Delete("DELETE FROM country WHERE country_id = #{id}")
  int deleteCountryById(int id);

  @Delete("DELETE FROM country WHERE country_id = #{id}")
  int deleteCountry(Country c);

}
