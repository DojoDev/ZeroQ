//
//  SingUpViewController.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import UIKit

extension UITextField {
    func addBottomBorderWithColor(color: UIColor, height: CGFloat) {
        let border = UIView()
        border.autoresizingMask = [.flexibleWidth, .flexibleHeight]
        
        border.frame = CGRect(x:self.frame.origin.x,
                              y: self.frame.origin.y+self.frame.height-height, width: self.frame.width, height: height)
        border.backgroundColor = color
        self.superview!.insertSubview(border, aboveSubview: self)
    }
}

class SingUpViewController: UIViewController {

    @IBOutlet weak var passwordTextField: UITextField!
    @IBOutlet weak var emailTextField: UITextField!
    @IBOutlet weak var nameTextField: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()
        self.title = "REGISTRE-SE"
        nameTextField.addBottomBorderWithColor(color: UIColor.black, height: 2)
        emailTextField.addBottomBorderWithColor(color: UIColor.black, height: 2)
        passwordTextField.addBottomBorderWithColor(color: UIColor.black, height: 2)
        // Do any additional setup after loading the view.
    }
}
