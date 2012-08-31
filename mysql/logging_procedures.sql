DELIMITER ;

CREATE DATABASE  IF NOT EXISTS `fred` ;
use `fred`;

DROP PROCEDURE IF EXISTS `doLog` ;
DROP PROCEDURE IF EXISTS `writeLogWithLast` ;
DROP PROCEDURE IF EXISTS `setupLogging` ;
DROP PROCEDURE IF EXISTS `setupTmpLog` ;


DELIMITER ;;
/* this is a general logging call */
CREATE DEFINER=`root`@`localhost`PROCEDURE `doLog`(in logMsg varchar(512))
BEGIN
  Declare continue handler for 1146 -- Table not found
  BEGIN
     call setupTmpLog();
     insert into tmplog values('resetup tmp table');
     insert into tmplog values(logMsg);
  END;
 
  insert into tmplog values(logMsg);
END;;

/*this is save all prior logging statements and save this last message 
  the id is used to mark the batch */

CREATE DEFINER=`root`@`localhost`  PROCEDURE `writeLogWithLast`(in thingId int, in lastMsg varchar(512))
BEGIN
   call dolog(lastMsg);
   insert into log(thingId, msg) (select thingId, msg from tmplog);
   truncate table tmplog;
END;; 

/* create the table that will store the log messages ISAM to allow 
writes even when transactions are rolled back */

CREATE  DEFINER=`root`@`localhost`  PROCEDURE `setupLogging`()
BEGIN

create table if not exists 
log (ts timestamp default current_timestamp, 
thingID bigint, msg varchar(512)) engine = myisam; 

END;;

/* set up the in memory temp table to store messages */
CREATE  DEFINER=`root`@`localhost` PROCEDURE `setupTmpLog`()
BEGIN
create temporary table if not exists tmplog (msg varchar(512)) engine = memory;
END;;

