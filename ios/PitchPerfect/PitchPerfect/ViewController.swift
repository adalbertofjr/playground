//
//  ViewController.swift
//  PitchPerfect
//
//  Created by Adalberto Fernandes Junior on 23/12/16.
//  Copyright © 2016 Adalberto Fernandes Junior. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var recordingLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


    @IBAction func recordAudio(_ sender: Any) {
        print("record button was pressing")
        recordingLabel.text = "Recording in Progress"
    }
    
    @IBAction func stopRecordin(_ sender: Any) {
        print("stop record button was pressing")
        recordingLabel.text = "Tap to Recording"
    }
}

