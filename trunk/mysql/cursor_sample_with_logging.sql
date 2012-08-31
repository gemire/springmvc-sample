delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_cursor_example`(
  IN customer_number_in INT(11), log_number_in INT(11)
)
    READS SQL DATA
BEGIN

  /*
    All 'DECLARE' statements must come first
    http://www.roseindia.net/mysql/mysql5/mysql-string-function.shtml for functions
    http://www.java2s.com/Tutorial/MySQL/0201__Procedure-Function/Catalog0201__Procedure-Function.htm
  */

  -- Declare '_val' variables to read in each record from the cursor
  DECLARE check_number VARCHAR(255);
  DECLARE payment_date DATETIME;
  DECLARE check_amount DOUBLE;

  -- Declare variables used just for cursor and loop control
  DECLARE no_more_rows BOOLEAN;
  DECLARE loop_cntr INT DEFAULT 0;
  DECLARE num_rows INT DEFAULT 0;

  -- Declare the cursor
  DECLARE payments_cur CURSOR FOR
    SELECT
        checkNumber, paymentDate, amount
       
    FROM classicmodels.Payments
    WHERE customerNumber = customer_number_in;

  -- Declare 'handlers' for exceptions
  DECLARE CONTINUE HANDLER FOR NOT FOUND
    SET no_more_rows = TRUE;

  /*
    Now the programming logic
  */

  -- 'open' the cursor and capture the number of rows returned
  -- (the 'select' gets invoked when the cursor is 'opened')
  OPEN payments_cur;
  select FOUND_ROWS() into num_rows;

  the_loop: LOOP

    FETCH  payments_cur
    INTO   check_number, payment_date, check_amount;

    -- break out of the loop if
      -- 1) there were no records, or
      -- 2) we've processed them all
    IF no_more_rows THEN
        CLOSE payments_cur;
        LEAVE the_loop;
    END IF;

    -- the equivalent of a 'print statement' in a stored procedure
    -- it simply displays output for each loop
    -- select check_number, payment_date, check_amount;

call doLog(concat('check_num, ... : ',check_number,',',format(check_amount,2),',',DATE_FORMAT(payment_date,'%m/%d/%y')));

    -- count the number of times looped
    SET loop_cntr = loop_cntr + 1;

  END LOOP the_loop;

  -- 'print' the output so we can see they are the same
  -- select num_rows, loop_cntr;
  call saveAndLog(log_number_in,concat('rows,counter: ',format(num_rows,0),' -- ',format(loop_cntr,0)));

END$$

