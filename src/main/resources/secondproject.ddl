DROP TABLE IF EXISTS userinfo;
DROP TABLE IF EXISTS replyinfo;
DROP TABLE IF EXISTS reviewinfo;
DROP TABLE IF EXISTS postinfo;

/**********************************/
/* Table Name: postinfo */
/**********************************/
CREATE TABLE postinfo(
		post_no                       		INTEGER(100)		 NULL  AUTO_INCREMENT COMMENT 'post_no',
		post_title                    		VARCHAR(100)		 NULL  COMMENT 'post_title',
		post_content                  		VARCHAR(1000)		 NULL  COMMENT 'post_content',
		post_writer                   		VARCHAR(100)		 NULL  COMMENT 'post_writer',
		post_views                    		INTEGER(100)		 NULL  COMMENT 'post_views'
) COMMENT='postinfo';

/**********************************/
/* Table Name: reviewinfo */
/**********************************/
CREATE TABLE reviewinfo(
		review_no                     		INTEGER(100)		 NULL  AUTO_INCREMENT COMMENT 'review_no',
		review_content                		VARCHAR(1000)		 NULL  COMMENT 'review_content',
		post_no                       		INTEGER(100)		 NULL  COMMENT 'post_no'
) COMMENT='reviewinfo';

/**********************************/
/* Table Name: replyinfo */
/**********************************/
CREATE TABLE replyinfo(
		reply_no                      		INTEGER(100)		 NULL  AUTO_INCREMENT COMMENT 'reply_no',
		reply_content                 		VARCHAR(1000)		 NULL  COMMENT 'reply_content',
		review_no                     		INTEGER(100)		 NULL  COMMENT 'review_no'
) COMMENT='replyinfo';

/**********************************/
/* Table Name: userinfo */
/**********************************/
CREATE TABLE userinfo(
		user_no                       		INTEGER(100)		 NULL  AUTO_INCREMENT COMMENT 'user_no',
		user_id                       		VARCHAR(50)		 NULL  COMMENT 'user_id',
		user_password                 		VARCHAR(50)		 NULL  COMMENT 'user_password',
		user_auth                 		VARCHAR(50)		 NULL  COMMENT 'user_auth'
) COMMENT='userinfo';


