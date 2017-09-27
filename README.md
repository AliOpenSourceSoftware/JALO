# JALO - A java.util.logger wrapper

A basic java utility logger wrapper with a custom handler that is designed to write to a file.


If desired, set the filename of the desired logging file. This must be done before instantiating an instance of the logger or calling the init() method.
### Installation
#### Maven  
``` 
<repositories>
  <repository>
    <id>aaronali-Java</id>
    <url>https://packagecloud.io/aaronali/Java/maven2</url>
    <releases>
      <enabled>true</enabled>
    </releases>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
</repositories> 
``` 

``` 
<dependency>
  <groupId>com.ali.java</groupId>
  <artifactId>jalo</artifactId>
  <version>1.0.0</version>
</dependency>
``` 

### Set logger file
Logger.fileName=fileName //can be path with filename

Initialize the logger if you want to use it statically first
Logger.init()

Creating and instance of the logger also calls the init() function internally. No neet to call init() manually if you use this approach.
Logger logger = new Logger()

## Static logging methods

### Info log
Logger.info(msg);

Logger.info(caller, method, msg);
### Warning log
Logger.warning(msg);

Logger.warning(caller, method,  msg);
### Error log
Logger.error(msg);

Logger.error(caller, method, msg);

Logger.error(caller, method, msg, exception);
### Severe log
Logger.severe(calller, method, msg,  exception);

## Instance logging
Logging for the instance and the static logger are almost identical. Instance logging methods are followed by a 'p' while 

### Info log
logger.infop(msg);

logger.infop(caller, method, msg);
### Warning log
logger.warningp(msg);

logger.warningp(caller, method,  msg);
### Error log
logger.errorp(msg);

logger.errorp(caller, method,  msg);

logger.errorp(caller, method,  msg, exception); 
### Severe log
logger.severep(caller, method, msg,  exception);
	          
## Additional Logging Methods
public static java.util.logging.Logger getLogger(string);
### Quick log to level
Logger.log(level, msg);

logger.logp(level, msg);
### Quick Info log
Logger.log(msg)

logger.logp(msg);
 	
	 
	 		
