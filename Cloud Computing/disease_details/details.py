from disease_details.connection import create_connection


def get_disease_details(predicted_class):
    connection = create_connection()
    try:
        with connection.cursor() as cursor:
            sql = "SELECT * FROM disease_details WHERE disease_name = %s"
            cursor.execute(sql, (predicted_class,))
            result = cursor.fetchone()

            if result is None:
                disease_details = ("Penyakit tidak diketahui",)
                handling_method = "Silakan konsultasikan dengan dokter hewan untuk diagnosis dan pengobatan lebih lanjut."

                return disease_details, handling_method

            disease_details = result["disease_detail"]
            handling_method = result["handling_method"]

            return disease_details, handling_method
    except:
        return "Connection to database Fail"

  
def get_all_disease():
    connection = create_connection()
    try:
        with connection.cursor() as cursor:
            sql = "SELECT * FROM disease_details"
            cursor.execute(sql)
            results = cursor.fetchall()

            diseases = []
            for result in results:
                disease_name = result["disease_name"]
                disease_details = result["disease_detail"]
                handling_method = result["handling_method"]
                diseases.append((disease_name, disease_details, handling_method))

            return diseases
    except:
        return "Connection to database Fail"