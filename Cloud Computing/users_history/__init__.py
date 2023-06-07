from flask import Blueprint
from .users_history import add_user_disease_history, get_users_history
users_disease_history_bp = Blueprint('users_disease_history', __name__)
from . import routes