//
//  EventCellTableViewCell.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import UIKit
import FontAwesome_swift
class EventCell: UITableViewCell {

    @IBOutlet weak var likeImageView: UIImageView!
    @IBOutlet weak var eventImageView: UIImageView!
    @IBOutlet weak var eventContainerInfo: UIView!
    override func awakeFromNib() {
        super.awakeFromNib()
        eventContainerInfo.layer.cornerRadius = 10
        eventImageView.layer.cornerRadius = 10
        likeImageView.image = UIImage.fontAwesomeIcon(name: .heart, style: .regular, textColor: UIColor.white, size: CGSize(width: 30, height: 30))
        likeImageView.layer.cornerRadius = likeImageView.frame.height/2
        self.backgroundColor = UIColor.clear
        
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
