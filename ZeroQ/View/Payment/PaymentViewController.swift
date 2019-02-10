//
//  PaymentViewController.swift
//  ZeroQ
//
//  Created by joão victor on 10/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import UIKit

class PaymentViewController: UIViewController {

    @IBOutlet weak var leftButton: UIButton!
    @IBOutlet weak var qrCodeImage: UIImageView!
    override func viewDidLoad() {
        super.viewDidLoad()

        leftButton.roundedButton(arrow: .arrowLeft)
    }


}
