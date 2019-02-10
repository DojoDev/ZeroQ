//
//  PaymentViewController.swift
//  ZeroQ
//
//  Created by joão victor on 10/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import UIKit

class PaymentViewController: UIViewController {
    
    @IBOutlet weak var qrCodeImage: UIImageView!
    static func instance()-> PaymentViewController {
        return UIStoryboard.storyboard(.payment).instantiateViewController() as PaymentViewController
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.title = "PAGAMENTO"
    }
}

extension PaymentViewController: Identifiable {}
