1.專案建構成Maven模組，該模組下有AnueMyBatisGen專案和AnueTest專案。 <br/>

2.AnueMyBatisGen專案為MyBatis連結DB後自動產生MyBatis需要使用到的Mapper和pojo等相關檔案。 <br/>

3.AnueTest專案為此次主要程式碼核心，技術架構使用到Spring Boot + Spring Web + MyBatis + Spring Validation + Swagger2 + Jedis。 <br/>
3_1.com.anue Package放Spring Boot啟動類。com.anue.config Package下放設定啟動類相關程式。com.anue.controller放Spring Restful Controller。<br/>
    com.anue.mapper Package放MyBatis需要使用到的Mapper程式。com.anue.pojo放MyBatis需要使用的Pojo檔。com.anue.redis Package放Redis相關檔案。 <br/>
    com.anue.service Package放Service的Interface。com.anue.service.impl Package放Service的實作類。com.anue.util Package放共用類，目前有一隻序列化反序列化程式。<br/>
    com.anue.test Package有單元測試用的Junit5測試程式。 <br/>
3_2.目前我運行測試方式是啟動後端的VM後，先啟動com.anue.AnueTestApplication.java，SpringBoot會啟動Embeded Tomcat在8080 Port。<br/>
    之後運行com.anue.test.UnitTestStockService.java做Junit的單元測試。 <br/>
3_3.com.anue.AnueTestApplication.java啟動後SwaggerUI的網址是http://localhost:8080/swagger-ui.html
