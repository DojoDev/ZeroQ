//
//  PurcaseCell.swift
//  ZeroQ
//
//  Created by joão victor on 10/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import UIKit

class PurchaseCell: UITableViewCell {
    
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var price: UILabel!
    @IBOutlet weak var productCategoryLabel: UILabel!
    @IBOutlet weak var productNameLabel: UILabel!
    @IBOutlet weak var productImageView: UIImageView!
    @IBOutlet weak var productImageContainerView: UIView!
    @IBOutlet weak var mainContainerView: UIView!
    @IBOutlet weak var removeItemButton: UIButton!
    @IBOutlet weak var buttonAdd: UIButton!
    @IBOutlet weak var buttonCountProducts: UIButton!
    override func awakeFromNib() {
        super.awakeFromNib()
        productImageContainerView.addCornerRadius(10)
        mainContainerView.addCornerRadius(10)
        buttonCountProducts.roundedButton()
        buttonCountProducts.setTitle("1", for: .normal)
        removeItemButton.roundedButton(icon: .minus)
        buttonAdd.roundedButton(icon: .plus)
        productImageView.addCornerRadius(10)
    }
}
