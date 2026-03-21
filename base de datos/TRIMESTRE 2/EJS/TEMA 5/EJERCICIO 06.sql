DROP TABLE IF EXISTS dashboard_dpto;
DROP TABLE IF EXISTS dashboard_centro;
CREATE TABLE dashboard_dpto AS SELECT d.CodDep, NomDep, PreAnu, COUNT(CodEmp) AS NumEmp, SUM(SalEmp) AS GatSal FROM departamento d LEFT JOIN empleado e ON d.CodDep = e.CodDep GROUP BY d.CodDep;
CREATE TABLE dashboard_centro AS SELECT c.CodCen, NomCen, COUNT(CodDep) AS NumDep, SUM(PreAnu) AS PreAnu FROM centro c LEFT JOIN departamento d ON c.CodCen = d.CodCen GROUP BY c.CodCen;