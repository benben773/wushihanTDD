-- 贷款资料
INSERT INTO `user_loan_plan_material` (`name`, `lender_age`, `id_card`, `gender`, `income`, `created_at`, `updated_at`)
VALUES ('刘德华', '30', '410000000000000001', 'MALE', '1000000', '2021-10-22 18:10:37.000000',
        '2021-10-22 18:10:37.000000');
-- 房产信息
INSERT INTO `house_material` (`age`, `loan_plan_material_id`, `price`)
VALUES ('10', '1', '10000000');

-- 共同还款人
INSERT INTO `together_lender` (`name`, `id_card`, `loan_plan_material_id`, `income`)
VALUES ('朱丽倩', '410000000000000002', '1', '1000000');
