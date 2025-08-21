ALTER TABLE pacientes ADD COLUMN ativo boolean DEFAULT true NOT NULL;
UPDATE pacientes SET ativo = true;
