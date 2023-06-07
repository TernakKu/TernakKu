from disease_details import create_connection

def add_user_disease_history(userId, name, disease_name, img_url):
    connection = create_connection()
    try:
        with connection.cursor() as cursor:
            sql = "INSERT INTO users_disease_history (userId, name, disease_name, img_url) VALUES(%s, %s, %s, %s);"
            cursor.execute(sql, (userId, name, disease_name, img_url))

            connection.commit()

            if cursor.rowcount > 0:
                return "Data inserted successfully"
            else:
                return "Failed to insert data into database"
            
    except:
        return "Connection to database Fail"
    
    finally:
        connection.close()


def get_users_history(userId):
    connection = create_connection()
    try:
        with connection.cursor() as cursor:
            sql = "SELECT disease_name, img_url FROM users_disease_history WHERE userId = %s;"
            cursor.execute(sql, (userId))
            results = cursor.fetchall()
            
            history = []
            for result in results:
                disease_name = result["disease_name"]
                img_url = result["img_url"]
                history.append((disease_name, img_url))

            return history
    except:
        return "Connection to database Fail"
    
    finally:
        connection.close()