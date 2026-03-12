CREATE TABLE passbook
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    category VARCHAR(256) NOT NULL,
    method VARCHAR(256) NOT NULL,
    amount INT,
    Continue VARCHAR(256) NOT NULL,
    memo TEXT,
    date DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE Amounts
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    totalAmount INT,
    targetAmount INT,
    difference INT
);

