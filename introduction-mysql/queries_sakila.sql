show tables;

SELECT c.country, ci.city, ad.address address_store, ad.phone phone_store, cm.first_name firstname_customer, cm.last_name lastname_customer,
	py.amount payment_customer, sf.first_name firstname_staff, sf.last_name lastname_staff, fl.title title_film, fl.description description_film,
    lg.name language, ct.name name_category, ac.first_name firstname_actor, ac.last_name lastname_actor
	FROM country c
    INNER JOIN city ci ON  ci.country_id = c.country_id
    INNER JOIN address ad ON ad.city_id = ci.city_id
    #INNER JOIN store st ON st.address_id = ad.address_id
    INNER JOIN customer cm ON cm.address_id = ad.address_id
    INNER JOIN payment py ON py.customer_id = cm.customer_id
    INNER JOIN staff sf ON sf.staff_id = py.staff_id
    INNER JOIN rental rt ON rt.rental_id = py.rental_id
    INNER JOIN inventory inv ON inv.inventory_id = rt.inventory_id
    INNER JOIN film fl ON fl.film_id = inv.film_id
    INNER JOIN language lg ON lg.language_id = fl.language_id
    INNER JOIN film_category fc ON fc.film_id = fl.film_id
    INNER JOIN category ct ON ct.category_id = fc.category_id
    INNER JOIN film_actor fa ON fa.film_id = fl.film_id
    INNER JOIN actor ac ON ac.actor_id = fa.actor_id
    WHERE c.country = "United States";
    
SELECT * FROM staff;

# --------------------------------------------------------
SELECT c.country, ci.city, ad.address address_store, ad.phone phone_store, cm.first_name firstname_customer, cm.last_name lastname_customer,
	SUM(py.amount) payment_customer
	FROM country c
    INNER JOIN city ci ON  ci.country_id = c.country_id
    INNER JOIN address ad ON ad.city_id = ci.city_id
    #INNER JOIN store st ON st.address_id = ad.address_id
    INNER JOIN customer cm ON cm.address_id = ad.address_id
    INNER JOIN payment py ON py.customer_id = cm.customer_id
    WHERE c.country = "United States"
    GROUP BY cm.customer_id
    ORDER BY payment_customer DESC;