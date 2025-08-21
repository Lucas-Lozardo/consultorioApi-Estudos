ALTER table medicos ADD COLUMN ativo BOOLEAN DEFAULT TRUE NOT NULL;
UPDATE medicos set ativo = TRUE;