//
//  ErrorManager.swift
//  unycos
//
//  Created by Erick Vicente on 22/05/18.
//  Copyright © 2018 GRUPO M CONTIGO S.L. All rights reserved.
//

import UIKit

struct ErrorManager {
    func handle(_ error: ServiceError,
                on viewController: UIViewController? = nil,
                completion: (() -> ())? = nil) {
        
        guard let message = self.message(for: error) else { return }
        
        let alertController = UIAlertController(title: "", message: message, preferredStyle: .alert)
        
        let OKAction = UIAlertAction(title: "OK", style: .default) { (action) in
            alertController.dismiss(animated: true, completion: nil)
        }
        
        alertController.addAction(OKAction)
        
        
        viewController?.present(alertController, animated: true, completion: nil)
    }
    
    func errorDescription(for error: ServiceError)-> String{
        let messageError = self.message(for: error)
        if let message = messageError {
            return message
        }
        return "Error"
    }
    
    private func message(for error: ServiceError) -> String? {
        switch error {
        case .modelMapping:
            return "Map model error"
        case let .statusCode(_, response):
            return response.message
        case .unauthorized, .invalidToken:
            return "Your session has expired. Please log in again"
        case .notConnectedToInternet:
            return "Connection not found"
        default:
            return "Unexpected Error"
        }
    }
}

