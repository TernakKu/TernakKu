from flask import Blueprint, jsonify
from . import get_disease_details, get_all_disease
from . import disease_details_bp

@disease_details_bp.route('/details/<disease_name>', methods=['GET'])
def details(disease_name):
    disease_details, handling_method = get_disease_details(disease_name)

    response = {
        'disease_name': disease_name,
        'disease_details': disease_details,
        'handling_method': handling_method
    }

    return jsonify(response)

@disease_details_bp.route('/all_disease', methods=['GET'])
def details():
    disease_name, disease_details, handling_method = get_all_disease()

    response = {
        'disease_name': disease_name,
        'disease_details': disease_details,
        'handling_method': handling_method
    }

    return jsonify(response)
