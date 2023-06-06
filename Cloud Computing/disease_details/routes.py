from flask import Blueprint, jsonify
from . import get_disease_details, get_all_disease
from . import disease_details_bp, get_diseases_bp

@disease_details_bp.route('/details/<disease_name>', methods=['GET'])
def details(disease_name):
    disease_details, handling_method = get_disease_details(disease_name)

    response = {
        'disease_name': disease_name,
        'disease_details': disease_details,
        'handling_method': handling_method
    }

    return jsonify(response)

@get_diseases_bp.route('/diseases', methods=['GET'])
def diseases():
    diseases = get_all_disease()

    response = []
    for disease in diseases:
        disease_name, disease_details, handling_method = disease
        response.append({
            'disease_name': disease_name,
            'disease_details': disease_details,
            'handling_method': handling_method
        })

    return jsonify(response)
