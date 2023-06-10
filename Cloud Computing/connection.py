import pymysql


def create_connection():
    connection = pymysql.connect(
        host="057",
        user="",
        password="",
        db="ternakku",
        charset="utf8mb4",
        cursorclass=pymysql.cursors.DictCursor,
    )
    return connection
