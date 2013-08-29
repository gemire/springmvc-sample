package net.thornydev.mybatis.koan.koan05;

import java.util.List;
import java.util.Map;

import net.thornydev.mybatis.koan.domain.Country;

import org.apache.ibatis.annotations.MapKey;

public interface Koan05Mapper {

  Country getCountryById(int id);

  List<Country> getAllCountries();

  @MapKey("id")
  Map<Integer, Country> getAllCountriesMappedById();

}
