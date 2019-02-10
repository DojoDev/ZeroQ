//
//  LoginViewController.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import UIKit

class LoginViewController: UIViewController {

    @IBOutlet weak var loginTextView: UITextField!
    @IBOutlet weak var passwordTextView: UITextField!
    @IBOutlet weak var submitButton: UIButton!
    override func viewDidLoad() {
        super.viewDidLoad()
        
        setupView()
       
    }
 
    @IBAction func submit(_ sender: Any) {
    }
    
}

//Mark setup views
extension LoginViewController {
    private func setupView() {
        submitButton.layer.cornerRadius = 25
    }
}
