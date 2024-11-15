-- Inserindo dados na tabela `organization`
INSERT INTO `organization` (id, name, address) VALUES 
    (NEXTVAL('organization_seq'), 'Sports World', '123 Main St, Cityville'),
    (NEXTVAL('organization_seq'), 'Marathon Masters', '456 Park Ave, Metropolis'),
    (NEXTVAL('organization_seq'), 'Health and Fitness Inc.', '789 Fitness Blvd, Townsville');
