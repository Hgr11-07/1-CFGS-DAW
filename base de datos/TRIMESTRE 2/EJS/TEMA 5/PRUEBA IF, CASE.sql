DELIMITER //
CREATE OR REPLACE PROCEDURE categoriaEdad (IN edad INT)
BEGIN	
	DECLARE categoria VARCHAR(128);
    /*IF edad<18 THEN
    	SET categoria = 'Junior';
    ELSEIF edad<45 THEN 
    	SET categoria = 'Senior';
    ELSE
    	SET categoria = 'Veterano'
    END IF;*/
    
    CASE edad
    WHEN edad < 18 THEN 
    	SET categoria = 'Junior';
    
    WHEN edad < 45 THEN 
    	SET categoria = 'Senior';
    
    ELSE
    	SET categoria = 'Veterano'
    
    END CASE;
    
SELECT categoria;

END //

DELIMITER ;
CALL categoriaEdad(19);

-----------------------------------------------------------------

DELIMITER //
CREATE OR REPLACE PROCEDURE sumarHasta (IN tope INT, OUT suma INT)
BEGIN	
	DECLARE i INT;
    SET i = 1;
    SET suma = 0;
    
    /*WHILE i<=tope DO
    	SET suma = suma + i;
    	SET i = i + 1;
    END WHILE;*/

    /*REPEAT
    	SET suma = suma + i;
    	SET i = i + 1;
    UNTIL i > tope
    END REPEAT; */

    BUCLE: LOOP
    	IF i > tope THEN
    		LEAVE bucle;
        END IF;
        SET suma = suma + i;
    	SET i = i + 1;
    END LOOP;
    
END //

DELIMITER ;
CALL sumarHasta(10, @suma);
SELECT @suma;