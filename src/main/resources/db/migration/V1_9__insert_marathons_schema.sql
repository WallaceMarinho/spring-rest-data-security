-- Inserindo dados na tabela `marathon`
INSERT INTO `marathons` (id, name, date, location, duration) VALUES 
    (NEXTVAL('marathon_seq'), 'City Marathon', '2024-05-01', 'Cityville', 240),
    (NEXTVAL('marathon_seq'), 'National Fitness Challenge', '2024-07-15', 'Metropolis', 300),
    (NEXTVAL('marathon_seq'), 'Townsville Half Marathon', '2024-09-10', 'Townsville', 180);
