INSERT INTO customers(persona,display_name,email,password_hash)
VALUES
('alice','Alice','alice@shopkart.test','pending'),
('bob','Bob','bob@shopkart.test','pending'),
('carol','Carol','carol@shopkart.test','pending');

INSERT INTO products
(sku,name,description,category,image_key,price_paise,stock)
VALUES
('SKU-BAG','Travel Bag','Travel backpack','Bags','bag',49900,10),
('SKU-PEN','Premium Pen','Smooth ink pen','Stationery','pen',9900,100),
('SKU-MUG','Coffee Mug','Ceramic mug','Kitchen','mug',24900,3),
('SKU-CAP','Baseball Cap','Cotton cap','Fashion','cap',39900,0),
('SKU-TEE','T-Shirt','Cotton T-Shirt','Fashion','tee',59900,25),
('SKU-KEY','Key Holder','Metal key holder','Accessories','key',14900,50);