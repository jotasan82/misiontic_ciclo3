SELECT 
    c.Code CodeCountry, c.Name Country, ci.Name City, cl.Language
FROM
    country AS c
        INNER JOIN
    city ci ON ci.CountryCode = c.Code
        INNER JOIN
    countrylanguage cl ON cl.CountryCode = c.Code
WHERE
    c.Code = 'COL';
    
SELECT COUNT(c.Name) num_ciudades, cl.Language FROM country AS c
	INNER JOIN city ci ON ci.CountryCode = c.Code
	INNER JOIN countrylanguage cl ON cl.CountryCode = c.Code
	WHERE c.Code = 'COL' GROUP BY cl.Language;