DROP TABLE IF EXISTS AUDIT_LOG;  
CREATE TABLE AUDIT_LOG (  
ID AUTO_INCREMENT PRIMARY KEY,  
CUSTOMER_NUMBER  VARCHAR(50) NOT NULL,  
PAYLOAD JSON NOT NULL  
); 
DROP TABLE IF EXISTS ERROR_LOG;  
CREATE TABLE ERROR_LOG (  
ID AUTO_INCREMENT PRIMARY KEY,  
ERROR_TYPE  VARCHAR(50) NOT NULL, 
ERROR_DESCRIPTION  VARCHAR(50) NOT NULL,   
PAYLOAD JSON NOT NULL  
);   