//
//  NewItemViewController.swift
//  eggplant-brownie-swift3
//
//  Created by Adalberto Fernandes Junior on 11/12/16.
//  Copyright © 2016 Adalberto Fernandes Junior. All rights reserved.
//

import UIKit

class NewItemViewController: UIViewController {
    
    var delegate:AddItemDelegate?
    
    @IBOutlet var nameField: UITextField?
    @IBOutlet var caloriesField: UITextField?
    
    
    init(delegate: AddItemDelegate){
        super.init(nibName: "NewItemViewController", bundle: nil)
        self.delegate = delegate
    }
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
    }

    @IBAction func addNewItem() {
        let name = nameField!.text
        let calories = Double(caloriesField!.text!)
        
        if(name == nil || calories == nil || delegate == nil){
            return
        }
        let item = Item(name: name!, calories: calories!)
        delegate!.add(item)
        
        if let navigation = navigationController{
            navigation.popViewController(animated: true)
        }
    }
}
