CREATE TABLE librarydb.user
(
  userid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  department VARCHAR(255) NOT NULL,
  sex VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX user_userid_uindex ON librarydb.user (userid);
ALTER TABLE librarydb.user ADD maxborrownum INT NOT NULL;
ALTER TABLE librarydb.user ADD nowborrownum INT NOT NULL;

CREATE TABLE librarydb.administrator
(
  aid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  aname VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX administrator_aid_uindex ON librarydb.administrator (aid);

CREATE TABLE librarydb.book
(
  bid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  bname VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  quantity INT NOT NULL,
  remainquantity INT NOT NULL
);
CREATE UNIQUE INDEX book_bid_uindex ON librarydb.book (bid);
ALTER TABLE librarydb.book ADD type VARCHAR(255) NOT NULL;
ALTER TABLE librarydb.book ADD finerate DOUBLE NOT NULL;

CREATE TABLE librarydb.borrowrecord
(
  rid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  uid INT NOT NULL,
  bid INT NOT NULL,
  borrowdate DATE NOT NULL,
  shouldreturndate DATE NOT NULL,
  returndate DATE
);
CREATE UNIQUE INDEX borrowrecord_rid_uindex ON librarydb.borrowrecord (rid);

CREATE TABLE librarydb.finerecord
(
  fid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  uid INT NOT NULL,
  bid INT NOT NULL,
  latedate INT NOT NULL,
  finetotal DOUBLE NOT NULL
);
CREATE UNIQUE INDEX finerecord_fid_uindex ON librarydb.finerecord (fid);

CREATE TABLE librarydb.email
(
  eid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  aid INT NOT NULL,
  content VARCHAR(500) NOT NULL
);
CREATE UNIQUE INDEX email_eid_uindex ON librarydb.email (eid);

