ALTER TABLE medicos ADD ativo TINYINT NOT NULL;

UPDATE medicos SET ativo = 1;