INSERT INTO passbook
(
    category,
    method,
    amount,
    Continue,
    memo
)
VALUES
    (
        '食費',
        '現金',
        '0',
        'ONE_MONTH',
        '例です'
    );

INSERT INTO Amounts
(
    totalAmount,
    targetAmount,
    difference
)
VALUES
    (
        '0',
        '0',
        '0'
    );