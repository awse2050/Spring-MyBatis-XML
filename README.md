# Spring-MyBatis-XML
----------
## boot-myBatis Repository 의 XML 버전

> Boot와 다르게 Spring Legacy 에서는 XML방식의 사용이 가능하므로 

> 연습했던 것과 다르게 XML방식으로 같은 과정을 구현하였음.


-------------------


+ DB 테이블 칼럼명과 Java Property가 일치하지 않을경우 매핑시켜주는 코드

**Boot**
```
@Results(id="CompanyMap", value={
  @Result(property = "name", column = "company_name"),
  @Result(property = "address", column = "company_address"),
  @Result(property = "employeeList", column = "id", many = @Many(select = "com.example.demo.mapper.EmployeeMapper.getByCompanyId"))
}) 
```

**XML**
```
<resultMap type="com.awse.domain.CompanyVO" id="companyMap">
  <id property="id" column="id" />
  <result property="id" column="id" />
  <result property="name" column="company_name" />
  <result property="address" column="company_address" />
  <collection property="employeeList" column="id" select="com.awse.mapper.EmployeeMapper.getByCompanyId" />
</resultMap>
  
  
  <select ~~~ resultMap="companyMap">  생략  </select>
```

-----------------------

+ Insert시 AutoIncreament로 생성되는 PK값을 즉시 Insert한 데이터에 pk값을 넣어주는 코드

**Boot**
```
@Insert("insert into company ( company_name, company_address) values ( #{company.name}, #{company.address} ) ")
@Options(useGeneratedKeys = true, keyProperty = "id") 
int insert(@Param("company") Company company);
```

**XML**
```
<insert id="insert" parameterType="com.awse.domain.CompanyVO" useGeneratedKeys="true" keyProperty="id">
  insert into company ( company_name, company_address ) values ( #{name} , #{address} )
</insert>
```
