INSERT INTO administrator (aid, aname) VALUES (1,'admin');

INSERT INTO book (bid, bname, description, quantity, remainquantity, finerate, type) VALUES (1,'鲁滨逊漂流记','鲁滨逊在一个小岛上面接受生存挑战的故事',10,10,0.5,'Normal');
INSERT INTO book (bid, bname, description, quantity, remainquantity, finerate, type) VALUES (2,'新华字典','工具书，适合所有年龄段使用',6,6,1.5,'Normal');
INSERT INTO book (bid, bname, description, quantity, remainquantity, finerate, type) VALUES (3,'善本金瓶梅','因其珍贵和少儿不宜，只能由老师看到',1,1,20.0,'TeacherOnly');
INSERT INTO book (bid, bname, description, quantity, remainquantity, finerate, type) VALUES (4,'IEEE论文合集','供研究生和老师查看',5,5,3.0,'UndergraduateForbidden');

INSERT INTO user (userid, name, type, department, sex, maxborrownum, nowborrownum) VALUES (1,'张三','Undergraduate','物理系','Male',1,0);
INSERT INTO user (userid, name, type, department, sex, maxborrownum, nowborrownum) VALUES (2,'李四','Graduate','计算机系','Male',2,0);
INSERT INTO user (userid, name, type, department, sex, maxborrownum, nowborrownum) VALUES (3,'Stefanie','Teacher','外语系','Female',3,0);