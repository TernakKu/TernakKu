from flask import Blueprint

disease_details_bp = Blueprint('disease_details', __name__)
get_diseases_bp = Blueprint('get_diseases', __name__)


from .details import get_disease_details
from .details import get_all_disease
# from .connection import create_connection
from . import routes


