CREATE OR REPLACE PROCEDURE encryptionPassword (text IN VARCHAR2, encrypted text OUT VARCHAR2) AS  
raw_set RAW(100);  
raw_password RAW(100);  
encryption_result RAW(100);  
encryption_password VARCHAR2(100) := 'Q?Tx.H9h@%5,:QxV';  
operation_mode NUMBER; 
BEGIN    
    raw_set:=utl_i18n.string_to_raw(text,'AL32UTF8');    
    raw_password := utl_i18n.string_to_raw(encryption_password,'AL32UTF8');        
    operation_mode:=DBMS_CRYPTO.ENCRYPT_DES + DBMS_CRYPTO.PAD_ZERO + DBMS_CRYPTO.CHAIN_ECB;        
    encryption_result:=DBMS_CRYPTO.ENCRYPT(raw_set,operation_mode,raw_password);           
    dbms_output.put_line(encryption_result);    
    encryptedtext := RAWTOHEX (encryption_result);  
END; 


CREATE OR REPLACE PROCEDURE decryptionPassword (encrypted_text IN VARCHAR2, decrypted_text OUT VARCHAR2) AS   
raw_set RAW(100);   
raw_password RAW(100);   
decryption_result RAW(100);   
decryption_password VARCHAR2(100) := 'Q?Tx.H9h@%5,:QxV';   
operation_mode NUMBER; 
BEGIN   
    raw_set:=HEXTORAW(encrypted_text);   
    raw_password :=utl_i18n.string_to_raw(decryption_password,'AL32UTF8');   
    operation_mode:=DBMS_CRYPTO.ENCRYPT_DES + DBMS_CRYPTO.PAD_ZERO + DBMS_CRYPTO.CHAIN_ECB;      
    decryption_result:=DBMS_CRYPTO.DECRYPT(raw_set,operation_mode,raw_password);   
    dbms_output.put_line(decryption_result);   
    decrypted_text := utl_i18n.raw_to_char (decryption_result,'AL32UTF8'); 
END;  
